package cn.yujian95.linkmonitor.agent;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YuJian95  yujian95_cn@163.com
 * @date 2021/7/24
 */
public class MyMonitorTransformer implements ClassFileTransformer {
    private static final Set<String> classNameSet = new HashSet<String>();

    static {
        classNameSet.add("cn.yujian95.linkmonitor.test.ApiTest");
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            String currentClassName = className.replaceAll("/", ".");

            if (!classNameSet.contains(currentClassName)) {
                return null;
            }

            System.out.println("transform:[" + currentClassName + "]");
            CtClass ctClass = ClassPool.getDefault().get(currentClassName);
            CtBehavior[] methods = ctClass.getDeclaredBehaviors();
            for (CtBehavior method : methods) {
                enhanceMethod(method);
            }
            return ctClass.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void enhanceMethod(CtBehavior method) throws Exception {
        if (method.isEmpty()) {
            return;
        }
        String methodName = method.getName();
        if ("main".equalsIgnoreCase(methodName)) {
            return;
        }

        final StringBuilder source = new StringBuilder();

        // 前置增强: 打入时间戳
        // 保留原有的代码处理逻辑
        source.append("{")
                //前置增强: 打入时间戳
                .append("long start = System.nanoTime();\n")
                //调用原有代码，类似于method();($$)表示所有的参数
                .append("$_ = $proceed($$);\n")
                .append("System.out.print(\"method:[")
                .append(methodName).append("]\");").append("\n")
                // 后置增强，计算输出方法执行耗时
                .append("System.out.println(\" cost:[\" +(System.nanoTime() - start)+ \"ns]\");")
                .append("}");

        ExprEditor editor = new ExprEditor() {
            @Override
            public void edit(MethodCall methodCall) throws CannotCompileException {
                methodCall.replace(source.toString());
            }
        };
        method.instrument(editor);
    }

}

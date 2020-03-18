import net.jfuentestgn.enslocals.api.EnsLocal;
import net.jfuentestgn.enslocals.domain.EnsLocalEntity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MakePopulate implements Runnable {

    private static final Class CLASS_ORIGIN = EnsLocalEntity.class;
    private static final Class CLASS_DEST = EnsLocal.class;

    private static final String VAR_ORIGIN = "entity";
    private static final String VAR_DEST = "vo";
    private static final String POPULATE_NAME = "populateEnsLocal";


    public MakePopulate() {
    }

    @Override
    public void run() {
        try {
            Class classOrigin = CLASS_ORIGIN;
            Class classDest = CLASS_DEST;

            List<String[]> gettersAndSetters = new ArrayList<>();

            // Loop all setter methods in classDest
            Method[] destMethods = classDest.getMethods();
            for (Method m : destMethods) {
                if (m.getName().startsWith("set")) {
                    String setter = m.getName();
                    String getter = "g" + setter.substring(1);
                    if (this.methodExistsInClass(classOrigin, getter)) {
                        gettersAndSetters.add(new String[] {setter, getter});
                    }
                }
            }

            buildCode(gettersAndSetters);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void buildCode(List<String[]> gettersAndSetters) {
        String originClassName = CLASS_ORIGIN.getSimpleName();
        String destClassName = CLASS_DEST.getSimpleName();
        StringBuffer sb = new StringBuffer();
        sb.append("private " + destClassName + " " + POPULATE_NAME + "(final " + originClassName + " " + VAR_ORIGIN + ") {\n");
        sb.append("\t" + destClassName + " " + VAR_DEST + " = new " + destClassName + "();\n");
        for (String [] getAndSet : gettersAndSetters) {
            String setter = getAndSet[0];
            String getter = getAndSet[1];

            sb.append("\t" + VAR_DEST + "." + setter + "(" + VAR_ORIGIN + "." + getter + "());\n");
        }
        sb.append("\treturn " + VAR_DEST + ";\n");
        sb.append("}");
        System.out.println(sb);
    }

    boolean methodExistsInClass(Class cls, String methodName) {
        try {
            cls.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            return false;
        }
        return true;
    }

    public static void main(String [] args) {
        new MakePopulate().run();
    }


}

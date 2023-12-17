package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.Opcodes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3 {
    public Class<?> createClass() {
        return new ByteBuddy()
            .subclass(Object.class)
            .name("DynamicFibCalculator")
            .defineMethod("getFib", long.class, Modifier.PUBLIC).withParameters(int.class)
            .intercept(new Implementation() {
                @Override
                public ByteCodeAppender appender(Target target) {
                    return (mv, context, methodDescription) -> {
                        Label label = new Label();

                        mv.visitCode();

                        mv.visitVarInsn(Opcodes.ILOAD, 1);
                        mv.visitInsn(Opcodes.ICONST_2);
                        mv.visitJumpInsn(Opcodes.IF_ICMPGE, label);

                        mv.visitVarInsn(Opcodes.ILOAD, 1);
                        mv.visitInsn(Opcodes.I2L);
                        mv.visitInsn(Opcodes.LRETURN);

                        mv.visitLabel(label);
                        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                        mv.visitVarInsn(Opcodes.ALOAD, 0);
                        mv.visitVarInsn(Opcodes.ILOAD, 1);
                        mv.visitInsn(Opcodes.ICONST_1);
                        mv.visitInsn(Opcodes.ISUB);
                        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "DynamicFibCalculator", "getFib", "(I)J");
                        mv.visitVarInsn(Opcodes.ALOAD, 0);
                        mv.visitVarInsn(Opcodes.ILOAD, 1);
                        mv.visitInsn(Opcodes.ICONST_2);
                        mv.visitInsn(Opcodes.ISUB);
                        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "DynamicFibCalculator", "getFib", "(I)J");
                        mv.visitInsn(Opcodes.LADD);
                        mv.visitInsn(Opcodes.LRETURN);
                        mv.visitEnd();
                        return new ByteCodeAppender.Size(5, 2);
                    };
                }

                @Override
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            })
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();
    }

    @Test
    @DisplayName("createClass Test")
    public void fibCalculationTest()
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> createdClass = createClass();
        long actual = (long) createdClass.getDeclaredMethod("getFib", int.class)
            .invoke(createdClass.getDeclaredConstructor().newInstance(), 20);
        assertThat(actual).isEqualTo(6765);
    }
}

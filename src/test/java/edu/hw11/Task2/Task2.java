package edu.hw11.Task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2 {

    @Test
    @DisplayName("Multiple with ArithemticUtils")
    public void multipleClassAfterSum() {
        ByteBuddyAgent.install();
        new ByteBuddy()
            .redefine(ArithmeticUtils.class)
            .method(ElementMatchers.named("sum")).intercept(MethodDelegation.to(Multiply.class))
            .make()
            .load(ClassLoader.getSystemClassLoader(), ClassReloadingStrategy.fromInstalledAgent())
            .getLoaded();

        int actual = ArithmeticUtils.sum(20, 3);

        assertThat(actual).isEqualTo(60 );
    }
}

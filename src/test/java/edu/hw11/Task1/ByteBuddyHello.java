package edu.hw11.Task1;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ByteBuddyHello {
    @Test
    @DisplayName("byteBuddyToString Test")
    public void byteBuddyToString()
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> dynamicType = new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.named("toString"))
            .intercept(FixedValue.value("Hello, ByteBuddy!"))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();

        assertThat(dynamicType.getDeclaredConstructor().newInstance().toString()).isEqualTo("Hello, ByteBuddy!");
    }
}

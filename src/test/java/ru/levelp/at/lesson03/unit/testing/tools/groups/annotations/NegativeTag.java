package ru.levelp.at.lesson03.unit.testing.tools.groups.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Tag;
import ru.levelp.at.lesson03.unit.testing.tools.groups.TagNames;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Tag(TagNames.NEGATIVE_TAG)
public @interface NegativeTag {
}

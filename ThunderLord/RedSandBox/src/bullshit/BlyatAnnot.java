package bullshit;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface BlyatAnnot
{
    int xd() default 0;
}

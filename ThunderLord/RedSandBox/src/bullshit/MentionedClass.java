package bullshit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class MentionedClass
{
    
    public MentionedClass()
    {
        for (Field f : this.getClass().getDeclaredFields())
        {
            for (Annotation ann : f.getDeclaredAnnotations())
            {
                if (ann instanceof Mentioned)
                {
                    try
                    {
                        System.out.println("[Reflection] " + f.getType().getName() + " " + f.getName() + " = " + f.get(this));
                    }
                    catch(IllegalAccessException e)
                    {}
                }
            }
        }
    }
}

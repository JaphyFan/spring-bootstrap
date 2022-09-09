package com.japhy.basic;

import com.japhy.basic.CharDemo;
import java.time.LocalDate;
import java.time.temporal.Temporal;

/**
 * @author Japhy
 * @since 2022/7/6 15:21
 */
public class CommentDemo {

    /**
     * hello method to demonstrate java comment syntax.
     * <p>
     *     great works begin with greate pay.
     *     {@link LocalDate#now()}
     *     <ul>
     *         <li> first {@code com.japhy.basic.CommentDemo}</li>
     *         <li> second</li>
     *     </ul>
     * @see java.time.LocalDateTime#adjustInto(Temporal) 
     * @param charDemo
     * @return
     */
    public LocalDate hello(CharDemo charDemo) {
        return LocalDate.now();
    }

}

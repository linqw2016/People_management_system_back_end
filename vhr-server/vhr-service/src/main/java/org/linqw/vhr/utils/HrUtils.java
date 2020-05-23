package org.linqw.vhr.utils;

import org.linqw.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtils {
    public static Hr getCurrentHr(){
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}

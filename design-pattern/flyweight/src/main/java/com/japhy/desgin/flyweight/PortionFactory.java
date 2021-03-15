package com.japhy.desgin.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Japhy
 * @since 2021/2/24 19:38
 */
public class PortionFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortionFactory.class);

    private Map<PortionType, Portion> portionMap;

    public PortionFactory() {
        this.portionMap = new HashMap<>();
    }

    public Portion createPortion(PortionType portionType) {
        Portion portion = portionMap.get(portionType);
        if (Objects.isNull(portion)) {
            switch (portionType) {
                case POISON:
                    PoisonPortion poisonPortion = new PoisonPortion();
                    portionMap.put(portionType, poisonPortion);
                    break;
                case HEALING:
                    HealingPortion healingPortion = new HealingPortion();
                    portionMap.put(portionType, healingPortion);
                    break;
                case STRENGTH:
                    StrengthPortion strengthPortion = new StrengthPortion();
                    portionMap.put(portionType, strengthPortion);
                    break;
                default:
                    throw new IllegalArgumentException("don't have this portion type");
            }
        }
        return portionMap.get(portionType);
    }
}

package com.japhy.bootstrap.web.infrastructure.enums;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 日期范围枚举.
 *
 * @author Japhy
 * @since 2022/3/28 19:41
 */
@ToString
@AllArgsConstructor
@Getter
public enum DateRangeEnum {
    LAST_DAY(1, "昨天") {
        @Override
        public LocalDateTime getStartDate() {
            return LocalDate.now().minusDays(1).atTime(LocalTime.MIN);
        }

        @Override
        public LocalDateTime getEndDate() {
            return LocalDate.now().atTime(LocalTime.MAX);
        }
    },


    THIS_WEEK(2, "本周") {
        @Override
        public LocalDateTime getStartDate() {
            return LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                    .atTime(LocalTime.MIN);
        }

        @Override
        public LocalDateTime getEndDate() {
            return LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))
                    .atTime(LocalTime.MAX);
        }
    },

    LAST_WEEK(3, "上周") {
        @Override
        public LocalDateTime getStartDate() {
            return LocalDate.now().minusWeeks(1)
                    .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).atTime(LocalTime.MIN);
        }

        @Override
        public LocalDateTime getEndDate() {
            return LocalDate.now().minusWeeks(1)
                    .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).atTime(LocalTime.MAX);
        }
    },

    THIS_MONTH(4, "本月") {
        @Override
        public LocalDateTime getStartDate() {
            return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).atTime(LocalTime.MIN);
        }

        @Override
        public LocalDateTime getEndDate() {
            return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).atTime(LocalTime.MAX);
        }
    },

    LAST_MONTH(5, "上月") {
        @Override
        public LocalDateTime getStartDate() {
            return LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth())
                    .atTime(LocalTime.MIN);
        }

        @Override
        public LocalDateTime getEndDate() {
            return LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth())
                    .atTime(LocalTime.MAX);
        }
    },

    ;

    private final int id;

    private final String name;

    public abstract LocalDateTime getStartDate();

    public abstract LocalDateTime getEndDate();

    public static DateRangeEnum findById(Integer id) {
        return Arrays.stream(DateRangeEnum.values())
                .filter(dateRangeEnum -> Objects.equals(dateRangeEnum.id, id)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("can't find the DateRangeEnum valued %d", id)));
    }

}


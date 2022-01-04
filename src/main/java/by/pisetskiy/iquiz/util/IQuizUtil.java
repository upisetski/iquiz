package by.pisetskiy.iquiz.util;

import by.pisetskiy.iquiz.model.entity.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class IQuizUtil {

    public static <T, U> List<U> map(List<T> elements, Function<T, U> mapper) {
        return elements.stream().map(mapper).collect(Collectors.toList());
    }

    public static <T, U> Set<U> map(Set<T> elements, Function<T, U> mapper) {
        return elements.stream().map(mapper).collect(Collectors.toSet());
    }

    public static <T, U> U map(T element, Function<T, U> mapper) {
        return mapper.apply(element);
    }

    public static <E extends BaseEntity> Function<Long, E> mapper(Supplier<E> constructor) {
        return (id) -> {
            var entity = constructor.get();
            entity.setId(id);
            return entity;
        };
    }

    public static LocalDate toDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }

    public static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_DATE);
    }

    public static LocalDateTime toDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static Long getIdFromParams(Map<String, String> params, String param) {
        var value = params.get(param);
        return value != null ? Long.parseLong(value) : null;
    }

}

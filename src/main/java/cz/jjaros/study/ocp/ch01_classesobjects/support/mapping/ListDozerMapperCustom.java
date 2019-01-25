package cz.jjaros.study.ocp.ch01_classesobjects.support.mapping;

import org.dozer.DozerBeanMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ListDozerMapperCustom extends DozerBeanMapper {

    // varianta I.
    public <T> List<T> mapList(List<?> sources, Class<T> destinationClass) {
        return sources.stream()
                .map(e -> super.map(e, destinationClass))
                .collect(Collectors.toList());
    }

    // varianta II.
    public <I, O> List<O> map(List<I> sources, Class<O> destinationClass) {
        return sources.stream()
                .map(e -> super.map(e, destinationClass))
                .collect(Collectors.toList());
    }
}

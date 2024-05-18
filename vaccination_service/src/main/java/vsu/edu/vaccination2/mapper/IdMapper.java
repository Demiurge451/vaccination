package vsu.edu.vaccination2.mapper;

import vsu.edu.vaccination2.model.id_container.IdContainer;

import java.util.List;
import java.util.stream.Collectors;

public class IdMapper<T extends IdContainer<ID>, ID> {
    public List<ID> mapItemToId(List<T> podcasts) {
        return podcasts.stream()
                .map(T::getId)
                .collect(Collectors.toList());
    }
}

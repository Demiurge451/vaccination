package vsu.edu.vaccination.service;

import org.springframework.data.domain.PageRequest;
import vsu.edu.vaccination.model.Address;

import java.util.List;
import java.util.UUID;

public interface CrudService <T, ID> {
    List<T> getListOfItems(PageRequest pageRequest);
    T getById(ID id);
    void delete(ID id);
    void save(T item);
    T update(ID id, T item);
}

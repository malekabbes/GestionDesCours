package com.example.exam.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ControllerGeneric<T,ID> {
    @Autowired
    private ImplementationGeneric<T,ID> serviceG;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
        public T save(@RequestBody T t) throws Exception {
        T Response = (T) serviceG.save(t);
        return Response;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<T> RetrieveAll() {
        try {
            return serviceG.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ID id) {
        try {
            serviceG.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public T update(@RequestBody T t) throws Exception {
        return serviceG.update(t);
    }


}

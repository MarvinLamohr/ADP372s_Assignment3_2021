package za.ac.cput.repository;

import za.ac.cput.Entity.Employee;

public interface IRepository <T,ID>{
    public T create(T t);
    public T read(ID id);
    public T update(T t);
    public T delete(ID id);
}

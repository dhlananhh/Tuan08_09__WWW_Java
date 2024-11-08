package iuh.fit.se.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import iuh.fit.se.entities.Address;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "address", path = "address", exported = false)
public interface AddressRepository extends JpaRepository<Address, Integer> {

}

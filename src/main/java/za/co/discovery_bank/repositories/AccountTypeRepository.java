/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.discovery_bank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.discovery_bank.entities.AccountType;

/**
 *
 * @author ayuk
 */
@Repository
public interface AccountTypeRepository extends CrudRepository<AccountType,String>{
    
}

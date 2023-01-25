package weather.changer.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.Role;
import weather.changer.repository.RoleUserRepository;

@Service
@Transactional
@Log4j2
@AllArgsConstructor
public class RoleService {

    private final RoleUserRepository repository;

    public Role findRoleByName(String name) {
        Role byName = repository.findByName(name);
        if (byName.getId() == 0) {
            log.error("Добавление не произведено");
        } else {
            log.info("Добавление произведено");
        }
        return byName;
    }
}

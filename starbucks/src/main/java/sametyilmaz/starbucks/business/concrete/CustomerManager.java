package sametyilmaz.starbucks.business.concrete;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.starbucks.repository.UserRepository;

@Service
@AllArgsConstructor
public class CustomerManager implements sametyilmaz.starbucks.business.abstracts.CustomerManager {
    private final UserRepository repository;
    private final ModelMapper mapper;
}

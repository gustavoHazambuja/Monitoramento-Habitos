package Monitora_Habitos.Services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Monitora_Habitos.Entities.HabitRegister;
import Monitora_Habitos.Enums.StatusHabit;
import Monitora_Habitos.Exceptions.HabitRegisterException;
import Monitora_Habitos.Repositories.HabitRegisterRepository;

@Service
public class HabitRegisterService {
    
    @Autowired
    private HabitRegisterRepository habitRegisterRepository;


    @Transactional
    public HabitRegister create(HabitRegister habitRegister){

        return habitRegisterRepository.save(habitRegister);
    }

    @Transactional(readOnly = true)
    public Page<HabitRegister> getAll(Pageable pageable){
        
        Page<HabitRegister> result = habitRegisterRepository.findAll(pageable);

        return result;
    }

    @Transactional
    public HabitRegister updateStatus(UUID id, HabitRegister habitRegister){

        if(!habitRegisterRepository.existsById(id)){
            throw new HabitRegisterException("Registro de hábito com id " + id + " não encontrado.");
        }

        HabitRegister result = habitRegisterRepository.findById(id).get();

        result.setStatusHabit(StatusHabit.CONCLUIDO);

        return habitRegisterRepository.save(result);
    }
}

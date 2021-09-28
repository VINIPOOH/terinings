package ua.ivan.springtask.exception;

import org.springframework.validation.BindingResult;
import ua.ivan.springtask.dto.RegNoteDTO;

public class RegNoteDTONotValidException extends RuntimeException{
    private RegNoteDTO regNoteDTO;
    private BindingResult bindingResult;

    public RegNoteDTONotValidException(RegNoteDTO regNoteDTO, BindingResult bindingResult) {
        this.regNoteDTO = regNoteDTO;
        this.bindingResult = bindingResult;
    }

    public RegNoteDTO getRegNoteDTO() {
        return regNoteDTO;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}

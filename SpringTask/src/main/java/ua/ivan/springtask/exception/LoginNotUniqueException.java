package ua.ivan.springtask.exception;

import ua.ivan.springtask.dto.RegNoteDTO;

public class LoginNotUniqueException extends RuntimeException {
    private RegNoteDTO regNoteDTO;
    public LoginNotUniqueException(String message) {
        super(message);
    }

    public RegNoteDTO getRegNoteDTO() {
        return regNoteDTO;
    }

    public void setRegNoteDTO(RegNoteDTO regNoteDTO) {
        this.regNoteDTO = regNoteDTO;
    }
}

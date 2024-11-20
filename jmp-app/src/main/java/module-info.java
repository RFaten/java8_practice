import com.epam.jmp.bank.Bank;
import com.epam.jmp.service.Service;

module com.epam.jmp.run {
    uses Bank;
    uses Service;
    requires jmp.cloud.bank.impl;
    requires jmp.cloud.service.impl;
    requires jmp.dto;

    exports com.epam.jmp.run;
}

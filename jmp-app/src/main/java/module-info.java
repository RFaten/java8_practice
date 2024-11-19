import com.epam.jmp.service.Bank;

module com.epam.jmp.run {
    uses Bank;
    requires jmp.dto;
    requires jmp.bank.api;
    requires jmp.cloud.bank.impl;

    exports com.epam.jmp.run;
}

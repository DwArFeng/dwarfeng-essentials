package com.dwarfeng.essentials.node.all.he.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ExceptionCodeOffsetConfiguration {

    @Value("${com.dwarfeng.essentials.essentials.exception_code_offset.acckeeper}")
    private int acckeeperExceptionCodeOffset;
    @Value("${com.dwarfeng.essentials.essentials.exception_code_offset.rbacds}")
    private int rbacdsExceptionCodeOffset;
    @Value("${com.dwarfeng.essentials.essentials.exception_code_offset.buddy}")
    private int buddyExceptionCodeOffset;
    @Value("${com.dwarfeng.essentials.essentials.exception_code_offset.settingrepo}")
    private int settingrepoExceptionCodeOffset;
    @Value("${com.dwarfeng.essentials.essentials.exception_code_offset.notify}")
    private int notifyExceptionCodeOffset;
    @Value("${com.dwarfeng.essentials.essentials.exception_code_offset.subgrade}")
    private int subgradeExceptionCodeOffset;
    @Value("${com.dwarfeng.essentials.essentials.exception_code_offset.spring_telqos}")
    private int springTelqosExceptionCodeOffset;
    @Value("${com.dwarfeng.essentials.essentials.exception_code_offset.spring_terminator}")
    private int springTerminatorExceptionCodeOffset;
    @Value("${com.dwarfeng.essentials.essentials.exception_code_offset.dwarfeng_datamark}")
    private int dwarfengDatamarkExceptionCodeOffset;
    @Value("${com.dwarfeng.essentials.essentials.exception_code_offset.dwarfeng_ftp}")
    private int dwarfengFtpExceptionCodeOffset;

    @PostConstruct
    public void init() {
        com.dwarfeng.acckeeper.sdk.util.ServiceExceptionCodes.setExceptionCodeOffset(acckeeperExceptionCodeOffset);
        com.dwarfeng.rbacds.sdk.util.ServiceExceptionCodes.setExceptionCodeOffset(rbacdsExceptionCodeOffset);
        com.dwarfeng.buddy.sdk.util.ServiceExceptionCodes.setExceptionCodeOffset(buddyExceptionCodeOffset);
        com.dwarfeng.settingrepo.sdk.util.ServiceExceptionCodes.setExceptionCodeOffset(settingrepoExceptionCodeOffset);
        com.dwarfeng.notify.sdk.util.ServiceExceptionCodes.setExceptionCodeOffset(notifyExceptionCodeOffset);
        com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes.setExceptionCodeOffset(
                subgradeExceptionCodeOffset
        );
        com.dwarfeng.springtelqos.sdk.util.ServiceExceptionCodes.setExceptionCodeOffset(
                springTelqosExceptionCodeOffset
        );
        com.dwarfeng.springterminator.sdk.util.ServiceExceptionCodes.setExceptionCodeOffset(
                springTerminatorExceptionCodeOffset
        );
        com.dwarfeng.datamark.sdk.util.ServiceExceptionCodes.setExceptionCodeOffset(
                dwarfengDatamarkExceptionCodeOffset
        );
        com.dwarfeng.ftp.sdk.util.ServiceExceptionCodes.setExceptionCodeOffset(
                dwarfengFtpExceptionCodeOffset
        );
    }
}

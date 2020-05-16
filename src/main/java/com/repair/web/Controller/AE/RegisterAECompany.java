package com.repair.web.Controller.AE;

import com.repair.web.Entity.Admin;
import com.repair.web.Entity.Company;
import com.repair.web.Service.AE.RegisterAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterAECompany {
    private final RegisterAEService registerAEService;

    public RegisterAECompany(RegisterAEService registerAEService){
        this.registerAEService=registerAEService;
    }

    @RequestMapping(value = "/RegisterCompany",method = RequestMethod.GET)
    public String registerCompanyPage(){
        return "RegisterCompany";
    }

    @RequestMapping(value = "/RegisterComSubmit",method = RequestMethod.POST)
    public String registerSubmit(String company_name,String company_info,String company_address,String company_business,String company_phone,String company_time) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(company_time);
        Company company=new Company();
        company.setCompany_name(company_name);
        company.setCompany_address(company_address);
        company.setCompany_info(company_info);
        company.setCompany_business(company_business);
        company.setCompany_phone(company_phone);
        company.setCompany_time(date);

        if(!registerAEService.registerCompany(company)){
            return "LoginAdmin";
        }
        else {
            return "Error";
        }
    }

    @RequestMapping(value = "/RegisterAdmin",method = RequestMethod.GET)
    public String registerAdmin(){
        return "RegisterAdmin";
    }

    @RequestMapping(value = "/RegisterAdSubmit",method = RequestMethod.POST)
    public String registerAdminSubmit(String admin_username,String admin_password,String admin_company){
        Admin admin=new Admin();
        admin.setAdmin_username(admin_username);
        admin.setAdmin_password(admin_password);
        admin.setAdmin_company(admin_company);
        if(!registerAEService.registerAdmin(admin)){
            return "LoginAdmin";
        }
        else{
            return "Error";
        }
    }
}

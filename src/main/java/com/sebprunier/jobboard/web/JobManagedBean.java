package com.sebprunier.jobboard.web;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.google.inject.Injector;
import com.sebprunier.jobboard.Job;
import com.sebprunier.jobboard.service.JobService;

@ManagedBean
@RequestScoped
public class JobManagedBean {

    private JobService jobService;

    public JobManagedBean() {
        super();
        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        Injector injector = (Injector) context.getAttribute(Injector.class.getName());
        this.jobService = injector.getInstance(JobService.class);
    }

    public List<Job> getAllJobs() {
        // JobService jobService = retrieveJobService();
        long currentTimeMillis = System.currentTimeMillis();
        jobService.create(new Job(String.valueOf(currentTimeMillis), "Job " + currentTimeMillis, "This is job number "
                + currentTimeMillis, new Date()));
        return jobService.getAll();
    }

}

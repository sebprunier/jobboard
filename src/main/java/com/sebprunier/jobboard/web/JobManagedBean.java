package com.sebprunier.jobboard.web;

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

    private Job newJob = new Job();

    public JobManagedBean() {
        super();
        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        Injector injector = (Injector) context.getAttribute(Injector.class.getName());
        this.jobService = injector.getInstance(JobService.class);
    }

    public List<Job> getAllJobs() {
        return jobService.getAll();
    }

    public String create() {
        jobService.create(newJob);
        reset();
        return null;
    }

    public Job getNewJob() {
        return newJob;
    }

    public void setNewJob(Job newJob) {
        this.newJob = newJob;
    }

    private void reset() {
        this.newJob = new Job();
    }
}

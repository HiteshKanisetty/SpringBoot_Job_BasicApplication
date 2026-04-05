package com.JobProj.Basic.Controller;


import com.JobProj.Basic.Service.JobService;
import com.JobProj.Basic.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {
//
//        @GetMapping("/")
//        public String home() {
//            return "home"; // home.html
//        }
//
//        @GetMapping("/addJob")
//        public String addJobPage() {
//            return "addJob";
//        }
//
//        @GetMapping("/viewJobs")
//        public String viewJobsPage() {
//            return "view-jobs";
//        }
    @Autowired
    private JobService service;

    // 🏠 HOME PAGE
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // ➕ OPEN ADD JOB PAGE
    @GetMapping("/addJob")
    public String addJobPage() {
        return "addJob";
    }

    // 💾 SAVE JOB (FORM SUBMIT)
    @PostMapping("/saveJob")
    public String saveJob(@ModelAttribute Job job) {
        service.saveJob(job);
        return "redirect:/viewJobs";
    }

    // 📋 VIEW ALL JOBS
    @GetMapping("/viewJobs")
    public String viewJobs(Model model) {
        model.addAttribute("jobs", service.getAllJobs());
        return "viewJob";
    }

    // ❌ DELETE JOB
    @GetMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable Long id) {
        service.deleteJob(id);
        return "redirect:/viewJobs";
    }

    // ✏️ OPEN EDIT PAGE
    @GetMapping("/editJob/{id}")
    public String editJob(@PathVariable Long id, Model model) {
        model.addAttribute("job", service.getJobById(id));
        return "edit-job";
    }

    // 🔄 UPDATE JOB
    @PostMapping("/updateJob")
    public String updateJob(@ModelAttribute Job job) {
        service.updateJob(job);
        return "redirect:/viewJobs";
    }

}

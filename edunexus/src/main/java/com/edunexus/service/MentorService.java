package com.edunexus.service;

import com.edunexus.entity.Mentor;
import java.util.List;

public interface MentorService {
    List<Mentor> searchMentors(String expertiseArea);
    Mentor getMentorByUserId(int userId);
}

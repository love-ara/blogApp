package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.models.data.User;
import africa.semicolon.blogApp.models.data.View;
import africa.semicolon.blogApp.models.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.blogApp.utils.Mapping.mapView;
@Service
public class ViewPostServicesImpl implements ViewPostServices {
    @Autowired
    private ViewRepository viewRepository;

    @Override
    public View viewPost(User viewer) {
        View view = mapView(viewer);
        viewRepository.save(view);
        return view;
    }
}

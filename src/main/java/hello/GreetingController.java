package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private UserList users = new UserList();
    private static final String successResponse = "Successfully ";
    private static final String failResponse = "Failed to ";
    


    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping(value="/view", method=RequestMethod.GET)
    public ArrayList<User> view() {
        return users.getUsers();
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> create(@RequestParam(value="username") String name, 
                      @RequestParam(value="password") String password) {
        String response = "";
        if (users.create(name, password)) {
            response += successResponse + "create " + name + " : " + password;
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }
        response += failResponse + "create " + name + " : " + password;
        return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> update(@RequestParam(value="username") String name, 
                      @RequestParam(value="password") String password) {
        String response = "";
        if (users.update(name, password)) {
            response += successResponse + "update " + name + " : " + password;
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }
        response += failResponse + "update " + name + " : " + password;
        return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam(value="username") String name) {
        String response = "";
        if (users.delete(name)) {
            response += successResponse + "delete " + name;
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }
        response += failResponse + "delete " + name;
        return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
    }
}
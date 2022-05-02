package f73.bredex.chatterbox.hello;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(tags="Accounts", hidden=false)
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(nickname = "getHello",
            value = "getHello", response = String.class, httpMethod = "GET") @
            ApiResponses({ @ApiResponse(code = 200, message = "getHello", response = String.class),
            @ApiResponse(code = 404, message = "shoud not happend.")})
    public String getHello(@RequestParam(required = false) String greeting){
        return greeting == null ?"Hello Superman" : greeting + " Superman";
    }

    @PostMapping("/mail")
    @ApiOperation(value = "Get a mail", notes = "Returns a mail as string")
    public String postBody(@RequestBody String mail) {
        return mail;
    }

    @PostMapping("/mailObject")
    @ApiOperation(value = "Get a mailObject", notes = "Returns a mail as object")
    public Mail postBodyWithObject(@RequestBody Mail mail) {
        return mail;
    }


}

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("SmokeTesting")
@SelectPackages("helpDesk")
@IncludeTags("Smoke")
public class SmokeSuite {
}

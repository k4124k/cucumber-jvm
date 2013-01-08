import cucumber.runtime.Runtime
import cucumber.runtime.RuntimeOptions
import cucumber.runtime.io.MultiLoader


main()

def main() {

    def classLoader = Thread.currentThread().getContextClassLoader()
    println(RuntimeOptions.USAGE)
    def path = System.getProperty("user.dir")
    System.setProperty("cucumber.options", "-n Division -f json-pretty:report/test.json -g $path\\src\\test\\groovy\\calc $path\\src\\test\\resources")
    String[] argv = []
    RuntimeOptions runtimeOptions = new RuntimeOptions(System.getProperties(), argv);

    Runtime runtime = new Runtime(new MultiLoader(classLoader), classLoader, runtimeOptions);
    runtime.writeStepdefsJson();
    runtime.run();
    System.exit(runtime.exitStatus());

}

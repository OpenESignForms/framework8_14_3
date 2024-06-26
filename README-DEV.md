# Development Instructions

*Updated by Yozons to reflect it's build of the 8.14.3 cloned repository using Eclipse 2022-06 (4.24.0),7 Java 1.8.0_261 for compiling
and JDK17 for the runtime.*

To contribute, first refer to [Contributing Code](https://github.com/vaadin/framework/blob/master/CONTRIBUTING.md)
for general instructions and requirements for contributing code to the Vaadin framework.

We appreciate all contributors and want to make submitting changes as easy as possible. If you find any mistakes, unclear parts or out-of-date instructions, please let us know by submitting an issue or a pull request.

#### Table of Contents
1. [Building a package](#building-a-package)
1. [About committing changes](#about-committing-changes)
1. [Eclipse quick setup](#eclipse-quick-setup)
1. [IntelliJ IDEA quick setup](#intellij-idea-quick-setup)

## Building a package

The distribution files can be built by running the standard Maven goal `mvn install` in the project root.

## About committing changes

Despite our best efforts the formatting options aren't always entirely consistent between different development environments, and sometimes we miss inconsistent formatting during code review. When you commit your changes for a pull request, try to make sure that the commit _only contains changes that are relevant to your patch,_ or at least closely affiliated with the relevant changes. Random formatting changes all over the changed file(s) make it difficult to grasp the main purpose of your patch.

## Eclipse quick setup

For IntelliJ IDEA users, see [IntelliJ IDEA Quick Setup](#intellij-idea-quick-setup).

1. Decide were you would like your Eclipse workspace to be located. 
    * This project contains multiple modules and uses configurations that might clash with your existing projects, using a separate workspace is recommended. *Yozons is using /Users/yozons/Documents/YozonsVaadin8Framework*
    * Eclipse Oxygen is recommended, different versions may treat formatting rules differently.  *Yozons is using Eclipse 2022-06 (4.24.0).*
    * If you are using Windows, you may wish to keep the workspace path reasonably short (e.g. `C:\dev\<workspaceName>`) to avoid problems with too long file paths.
1. Start Eclipse with your chosen workspace and set up [workspace preferences](#workspace-preferences).
1. Clone the repository within your selected workspace using Eclipse's clone wizard, using your favorite Git tool, or in command-line running
<code>git clone https://github.com/OpenEsignForms/framework8_14_3.git</code> command.
    * Eclipse's clone wizard can be found within Git perspective (*Window* -> *Perspectives* -> *Open Perspective* -> *Git*).  If *Git* is not shown, select *Other* and then choose *Git. _Only_ clone the project at this stage, do not let the clone wizard import projects as well.
      * Click *Clone a Git repository*
      * Select repository source *Clone URI* and click Next.
      * Enter *https://github.com/OpenEsignForms/framework8_14_3.git* in the URI.  It should show the host as *github.com* and the repository path
        as */OpenESignForms/framework8_14_3.git* and protocol as *https* and for Yozons, we entered our GitHub user and password.  Click Next.
      * Click Next and leave all branches checked.
      * Accept the local destination as Directory */Users/yozons/git/framework8_14_3*, initial branch *master* and remote name *origin* and uncheck *Import all existing Eclipse projects after clone finishes* and click Finish.
    * If using Windows, you might also want to add these Git settings: `core.autocrlf=false` and `core.fileMode=false`. You can do this in Eclipse by right-clicking the repository in Git perspective, clicking *Properties*, then *Add Entry...* and using key `core.autocrlf` and value `false` etc.
    * If too long file paths become a problem you may also need `core.longpaths=true`.
1. Switch to the Java EE perspective so see the Project Explorer.
1. Import the project into Eclipse as a Maven project. Use *File* -> *Import* -> *Maven* -> *Existing Maven Projects*.
1. Select the *framework* folder (where you cloned the project). Yozons used */Users/yozons/git/framework8_14_3*
    * It is not necessary to import all the modules, but it is recommended to include at least the root module, `vaadin-uitest` module, and any modules you may wish to make changes to. You can import more modules when needed by repeating these last steps.
    * Yozons kept all projects checked and the 'Add project(s) to working set' was set to *vaadin-root*.
1. Click “Finish” to complete the import of Vaadin Framework.

### Workspace preferences

The following preferences need to be set to keep the project consistent. You need to do this especially to be able to contribute changes to the project.

#### General

1. Open *Window* -> *Preferences* (Windows) or *Eclipse* -> *Settings* that opens Preferences (Mac)
1. Go to *General* -> *Workspace*
   - Set *Text file encoding* to *UTF-8*   *For Yozons, this is Default (UTF-8) selected.*
   - Set *New text file line delimiter* to *Unix*   *This was already the default.*
1. Go to *XML* -> *XML Files* -> *Editor*
   - Ensure the settings are follows:
     - Line width: 72   *This was already the default.*
     - Format comments: true  *This was already the default.*
     - Join lines: true *This was already the default.*
     - Insert whitespace before closing empty end-tags: true  *This was already the default.*
     - Indent-using spaces: true
     - Indentation size: 4
1. Go to *Java* -> *Compiler* -> *Errors/Warnings*
   - Switch *Serializable class without serialVersionUID* to *Ignore*
1. Go to *Java* -> *Installed JREs*
   - Select a Java 8 JDK as the default

#### Configuration files

1. Open *Window* -> *Preferences* (Windows) or *Eclipse* -> *Settings* for Preferences (Mac)
1. Go to *Java* -> *Code Style* -> *Clean Up*
   - Import [eclipse/VaadinCleanup.xml](/eclipse/VaadinCleanup.xml)
1. Go to *Java* -> *Code Style* -> *Formatter*
   - Import [eclipse/VaadinJavaConventions.xml](/eclipse/VaadinJavaConventions.xml)

#### Save actions

1. Open *Window* -> *Preferences* (Windows) or *Eclipse* -> *Settings* to open Preferences (Mac)
1. Go to *Java* -> *Editor* -> *Save Actions*
   - Check *Perform the selected actions on save*
      - Check *Format source code*
        - Select *Format edited lines*
   - Check *Organize imports*
   - Check *Additional actions*
   - Click *Configure*
     1. In tab *Code Organizing*
        - Check *Remove trailing whitespace*
          - Select *All lines*
        - Uncheck everything else
     1. In tab *Code Style*
        - Check *Use blocks in if/while/for/do statements*
          - Select *Always*
        - Uncheck everything else
     1. In tab *Member Accesses*
        - Check *Use 'this' qualifier for field accesses*
          - Select *Only if necessary*
        - Check *Use 'this' qualifier for method accesses*
          - Select *Only if necessary*
        - Uncheck everything else
     1. In tab *Missing Code*
        - Check *Add missing Annotations*  *This was the default.*
          - Check *'@Override'*
            - Check *Implementations of interface methods (1.6 or higher)*
          - Check *'@Deprecated'*
     1. In tab *Unnecessary Code*
        - Check *Remove unused imports* and *Remove unnecessary casts*, uncheck everything else.
     1. Click *OK*

After that is done, you should have 9 of 28 save actions activated and listed as such:

* Remove 'this' qualifier for non static field accesses
* Remove 'this' qualifier for non static method accesses
* Convert control statement bodies to block
* Remove unused imports
* Add missing '@Override' annotations
* Add missing '@Override' annotations to implementations of interface methods
* Add missing '@Deprecated' annotations
* Remove unnecessary casts
* Remove trailing white spaces on all lines

### Getting started

Run <code>install</code> maven goal for the project root to get started.
In Eclipse this is done by right-clicking on the project root in Project Explorer and choosing *Run As* -> *Maven Build...* . If you choose to skip tests you may need to run the <code>install</code> maven goal for `vaadin-uitest` project separately.
* Note that the first compilation takes a while to finish as Maven downloads dependencies used in the projects.

Now the project should compile without further configuration.

### Compiling the default widgetset and themes

* Yozons update: Use Maven in Eclipse to set the version to build as. For example, for the next release from the Vaadin official release of 8.14.3 to the Yozons patch build to 8.14.4, do *Run As* -> *Maven Build...* using the goal of `versions:set`, check `Skip Tests`, and add the parameters `newVersion=8.14.4` and `processAllModules=true`.
* Compile the default widgetset by running <code>install</code> maven goal in `vaadin-client-compiled` module root.
In Eclipse this is done by right clicking on `vaadin-client-compiled` project in Project Explorer and choosing *Run As* -> *Maven Build...*.
You don't need to do this separately if you have already run <code>install</code> for the root project after your latest changes. 
* Compile the default themes by running <code>install</code> maven goal in `vaadin-themes` module root.
In Eclipse this is done by right clicking on `vaadin-themes` project in Project Explorer and choosing *Run As* -> *Maven Build...*.
You don't need to do this separately if you have already run <code>install</code> for the root project after your latest changes.

### Running a UI test

#### Using DevelopmentServerLauncher (recommended)
1. In a Project Explorer navigate to *vaadin-uitest/src/main/java/com/vaadin/launcher*
1. Right-click file DevelopmentServerLauncher.java
1. Open *Run As* -> *Java Application*
1. Open URL [http://localhost:8888/run/&lt;testUI&gt;](http://localhost:8888/run/<testUI>)

#### Using Jetty
1. In a Project Explorer right-click *vaadin-uitest*
1. Open *Run As* -> *Maven build...*
1. Type in <code>jetty:run-exploded</code> into *Goals* and click *Run*
1. Open URL [http://localhost:8888/run/&lt;testUI&gt;](http://localhost:8888/run/<testUI>)

For full instructions please visit [README-TESTS.md](README-TESTS.md).

## IntelliJ IDEA quick setup

For Eclipse users, see [Eclipse Quick Setup](#eclipse-quick-setup).

1. Install and run IDEA. Ultimate Edition is better but Community Edition should also work.
1. Ensure if Git and Maven plugins are installed, properly configured and enabled.
1. Clone the repository, using menu VCS -> Checkout from Version Control -> Git -> Git Repository URL -> https://github.com/vaadin/framework.git.
  When the repository is cloned, do **NOT** open it as a project.
    * If you are using Windows, you may wish to keep the workspace path reasonably short (e.g. `C:\dev\<workspaceName>`) to avoid problems with too long file paths.
1. Open cloned repository as a maven object. Use File -> Open and choose root _pom.xml_ file
1. Have a coffee break while IDEA is loading dependencies and indexing the project
1. Run Maven targets <code>clean</code> and <code>install</code> using *Maven Projects* tool window to compile the whole project

Unfortunately there is no easy way to replicate [Eclipse workspace preferences](#workspace-preferences) in their entirety in IDEA, but you can use [Eclipse Code Formatter plugin](https://plugins.jetbrains.com/plugin/6546-eclipse-code-formatter) to import [eclipse/VaadinCleanup.xml](/eclipse/VaadinCleanup.xml) and [eclipse/VaadinJavaConventions.xml](/eclipse/VaadinJavaConventions.xml) as a starting point.

### Running a specific UI test

1. Open *Maven Projects*
1. Open *vaadin-uitest* -> *Plugins* -> *jetty* -> *jetty:run-exploded*
1. Open URL [http://localhost:8888/run/&lt;testUI&gt;](http://localhost:8888/run/<testUI>)

For full instructions please visit [README-TESTS.md](README-TESTS.md).

### Running a development server

1. Open *Run* menu  and click *Edit Configurations*
1. Click green ***+*** sign at top left corner, select *Maven* from popup
1. In the run configuration page, set any name for the configuration, select *vaadin-uitest* project folder as *Working directory*
1. Type <code>exec:exec@run-development-server</code> into *Command line* and save the configuration
1. Run the configuration and open URL [http://localhost:8888/run/&lt;testUI&gt;](http://localhost:8888/run/<testUI>)

### Running a development server in a debug mode

1. Type <code>exec:exec@debug-development-server</code> into *Command line* and save the configuration
1. In the same dialog, create new "Remote" debug configuration, using *localhost* and *Port 5005*
1. Start both configurations and open URL [http://localhost:8888/run/&lt;testUI&gt;](http://localhost:8888/run/<testUI>)

---
title: "Module: AEM Classic UI"
---

As of version `1.6.0` this module is marked as EOL - it is no longer maintained by Bobcat team. In case of any questions, let us know!
{: .notice--warning}

## Installation

To get AEM Classic UI module to be ready to use follow these two steps:

1. Add dependency into your `pom.xml` file:

    ```xml
        <dependency>
            <groupId>com.cognifide.qa.bb</groupId>
            <artifactId>bb-aem-classic</artifactId>
            <version>1.4.0</version>
        </dependency>
    ```
2. Add module installation to your `GuiceModule.java` file:
    ```java
        install(new AemClassicModule());
    ```

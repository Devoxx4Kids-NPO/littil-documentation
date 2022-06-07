---
hide:
  - navigation
  - toc
---

# Homepage
This is the root of the documentation site of the Littil platform. It supports Markdown and PlantUML. 

For example: 

```plantuml
@startuml
  Goofy ->  MickeyMouse: calls
  Goofy <-- MickeyMouse: responds
@enduml
```

Will generate:

![Example diagram](diagrams/out/example.svg) 

You can also include Gherkin files

~~~{.gherkin linenums=1 title="Teacher account feature"}
{% include "../integration/src/test/resources/features/teacher_account.feature" %}
~~~
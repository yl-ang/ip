# User Guide

Duke is a **desktop app** with a **graphical User Interface (GUI)** and a Personal Assistant Chat bot that helps a 
person to keep track of various things.

## Table of content
1. [Quick Start](#quick-start)
2. [Features](#features)
3. [Usage](#usage)

## Quick Start
1. Ensure that you have ``Java 11`` installed on your Computer.

2. Download the latest release of ```duke.jar``` from [release](https://github.com/yl-ang/ip/releases).

3. Double-click the file to start the app.

4. Type in the command in the message box and press ```Send``` to send over to Duke.
Some example commands you can try out:
* **`list`** : Lists all existing tasks.
* **`todo`**`iP User Guide` : Adds a todo task `iP User Guide` to Duke.
* **`deadline`**`user stories for tP /by 2022-02-15` : Adds a deadline task `user stories for tP` to be done
by `15/02/2022` Duke.

![UI Main](/ip/Ui.png)

5. Refer to the [Features](#features) below for details of each command.

## Features 

### Feature-todo

Allows you to add a todo task.

### Feature-deadline

Allows you to add a deadline task.

### Feature-event

Allows you to add an event task.

### Feature-update

Allows you to update an existing task.

### Feature-mark

Allows you to mark a task as done.

### Feature-unmark

Allows you to undo a marked task.

### Feature-find

Allows you to search for existing tasks based on a keyword.

### Feature-delete

Allows you to delete a task based on a task number.

### Feature-bye

Allows you to exit the application.

## Usage

### `todo` - Add a todo task.

Adds a todo task with a description into Duke.

Format: `todo [description]`
* Description of the todo task.

Example of usage: 

`todo preparing for LSM1301 lab`

Expected outcome:
```
Got it. l've added this task:
    [T][] preparing for LSM1301 lab
Now you have 1 task in the list.
```

### `deadline` - Adds a deadline task into Duke.

Adds a deadline task with a description and date to complete the task by into Duke.

Format `deadline [description] [/by date]`
* Description of the deadline task.
* The date must be in the format YYYY-MM-DD.

Example of usage:

`deadline user stories for tP /by 2022-02-15`

Expected outcome:
```
Got it. l've added this task:
    [D][] user stories for tP (by:
2022-02-15)
Now you have 1 task in the list.
```

### `event` - Adds an event task into Duke.

Adds an event task with a description and date the event happens at into Duke.

Format `event [description] [/at date]`
* Description of the event task.
* The date must be in the format YYYY-MM-DD.

Example of usage:

```event GET1020 Midterm /at 2022-02-28```

Expected outcome:
```
Got it. l've added this task:
    [E][] GET1020 Midterm (at:
2022-02-28)
Now you have 1 task in the list.
```


### `update` - Updates an existing task based on the task number.

Updates an existing task's description and date.

Format `update TASKNUMBER [d/Description] [t/date]`
* Updates the task at the supplied TASKNUMBER. The TASKNUMBER refers to the index number shown in
the task list. The TASKNUMBER must be a positive integer 1,2,3, ...
* New description of the task.
* Existing values will be updated to the input values.
* At least one of the optional fields must be provided.
* The date supplied must be in the format YYYY-MM-DD.

Example of usage:
```update 1 d/CS3230 Assingment 5 t/2022-02-13```
```update 1 t/2022-02-13 d/CS3230 Assingment 5```
```update 1 d/CS3230 Assingment 5```
```update 1 t/2022-02-13```

Expected outcome:
```
I've updated this task:
[D][] CS3230 Assingment 5 (by: 2022-02-13)
```


### `mark` - Mark an existing task as done based on the task number.

Mark an existing task as done with a cross.

Format `mark TASKNUMBER`
* Mark the task at the supplied TASKNUMBER as done if it is not done. The TASKNUMBER refers to 
the index number shown in the task list. The TASKNUMBER must be a positive integer 1,2,3,...

Example of usage:
```
mark 1
```

Expected outcome:
```
Nice! I've marked this taks as done:
[D][X] CS3230 Assingment 5 (by: 2022-02-13)
```


### `unmark` - Unmark an existing done task based on the task number.

Unmark an existing done task.

Format `unmark TASKNUMBER`
* unmark the task at the supplied TASKNUMBER. The TASKNUMBER refers to the index number shown in the task list.
The TASKNUMBER must be a positive integer 1,2,3,...

Example of usage:
```
unmark 1
```

Expected outcome:
```
Nice! I've marked this taks as done:
[D][] CS3230 Assingment 5 (by: 2022-02-13)
```


### `find` - Find existing tasks based on the supplied keyword.

Find existing tasks based on the supplied search keyword.

Format `find KEYWORD`
* find the tasks based on the supplied KEYWORD.

Example of usage:
```
find GET1020
```

Expected outcome:
```
Here are the matching tasks in your list:
1. [E][] GET1020 Midterm (at:
2022-02-28)
```


### `delete` - Delete an existing task based on the task number.

Delete an existing task based on the task number.

Format `Delete TASKNUMBER`
* Delete the task at the supplied TASKNUMBER. The TASKNUMBER refers to the index number shown in
  the task list. The TASKNUMBER must be a positive integer 1,2,3, ...

Example of usage:
```
delete 1
```

Expected outcome:
```
Noted. I've removed this task:
    [T][X] CS3230 Assignment 5.
Now you have 1 tasks in the list.
```


### `bye` - Exists the application.

Exits the application.

Format `bye`

Example of usage:
```
bye
```

Expected outcome:
* Application window closes.
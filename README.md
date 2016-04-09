# LeaveProject
This is a project of COMP5134

How to use this system:

In the user interface, the user can use button to come true all function

Add Staff button can add new stuff into system, passing click this button can put into the details about new add stuff.

Apply Leave button can appear the leave apply function, passing click user can choose the staff who want to apply and choose the data of start and end. All leave apply function in their.

In the table, user can choose edit button to edit the details about user who belong to the list, and delete button can delete the user.

Special situation:
Add new staff but don’t set a name: “Employee name cannot be empty”
When already set a director and want set another staff to a director:”Already have a director(Please cancel it firstly)”
Add new staff but don’t set a supervisor:”The employee’s supervisor can not be empty”
Delete a staff but he or she is a supervisor:”Have other employee under supervise, please cancel it firstly”
Set a leave application but the date of end is early than start date:”Error date” 
Set a leave application but do not choose the apply staff:”Please choose a applicant”
Set a leave application but do not set the start date:”Please set a start date”
Set a leave application but do not set the end date:”Please set a end date”

How to read the code:

Program entrence file：src/pers.jack.leave.ui/LeaveApp
Program main frame file:src/pers.jack.leave.ui/MainFrame

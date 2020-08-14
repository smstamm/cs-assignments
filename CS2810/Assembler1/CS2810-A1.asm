TITLE CS2810 Assembler Template

; Student Name: Stephanie Stamm
; Assignment Due Date: July 12, 2020

INCLUDE Irvine32.inc
.data
	;--------- Enter Data Here
	vSemester byte "CS2810 Summer Semester 2020",0
	vAssignment byte "Assembler Assignment #1",0
	vName byte "Stephanie Stamm",0
	

.code
main PROC
	;--------- Enter Code Below Here
	call clrscr

	mov dh, 2
	mov dl, 12
	call gotoxy

	mov edx, offset vSemester
	call WriteString

	mov dh, 3
	mov dl, 12
	call gotoxy

	mov edx, offset vAssignment
	call WriteString

	mov dh, 4
	mov dl, 12
	call gotoxy

	mov edx, offset vName
	call WriteString
	
	xor ecx, ecx
	call ReadChar

	exit
main ENDP

END main
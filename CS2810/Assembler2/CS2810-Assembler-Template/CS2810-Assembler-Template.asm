TITLE CS2810 Assembler Template

; Student Name:
; Assignment Due Date:

INCLUDE Irvine32.inc
.data
	;--------- Enter Data Here
	vSemester byte "CS 2810 Spring Semester 2020",0
	vAssignment byte "Assembler Assignment #2",0
	vName byte "Stephanie Stamm",0
	vPrompt byte "Please enter a FAT16 file time in hex: ",0
	vTimeField byte "--:--:--",0


.code
main PROC
	;--------- Enter Code Below Here
	
	;--------- Semester
	mov dh, 15
	mov dl, 20
	call gotoxy
	
	mov edx, offset vSemester
	call WriteString


	;--------- Assignment
	mov dh, 16
	mov dl, 20
	call gotoxy

	mov edx, offset vAssignment
	call WriteString				; Always calls what's in the EDX register


	;--------- Name
	mov dh, 17
	mov dl, 20
	call gotoxy

	mov edx, offset vName
	call WriteString

	
	;--------- Time setup
	mov dh, 19
	mov dl, 20
	call gotoxy

	mov edx, offset vPrompt
	call WriteString

	call ReadHex

	ror ax, 8

	mov ecx, eax

	;--------- Hours
	and ax, 1111100000000000b			; Use five 1s because that will isolate the first five bits for the hours
	shr ax, 11							; Shift right 11 to move the five bits we care about all the way to the right
	mov bh, 10
	div bh								; Divide by 10 to convert hex to decimal. No need to specify a register - it is always AX for 8-bit division
	add ax, 3030h						; ASCII nums start at 30, so add 30 each to high and low registers
	
	mov word ptr [vTimeField+0], ax		; +0 is the offset in our variable for where we want the hours to display
	mov edx, offset vTimeField


	;--------- Minutes
	mov eax, ecx						; Copy the contents of the cx register back into ax
	and ax, 0000011111100000b			; Use six 1s in the middle to isolate the six minute bits
	shr ax, 5							; Shift the minute bits to the end
	div bh								; Value of bh is already 10, divide to convert to decimal
	add ax, 3030h						; Convert to ASCII
	
	mov word ptr [vTimeField+3], ax		; +3 is the minutes offset
	mov edx, offset vTimeField


	;--------- Seconds
	mov eax, ecx
	and ax, 0000000000011111b			; No need to shift right - the bits are already in place
	shl ax, 1							; Seconds need to be multiplied by 2 which is accomplished by shifting left
	div bh
	add ax, 3030h

	mov dh, 20
	mov dl, 20
	call gotoxy

	mov word ptr [vTimeField+6], ax
	mov edx, offset vTimeField

	call WriteString
	
	xor ecx, ecx
	call ReadChar

	exit
main ENDP

END main
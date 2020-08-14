TITLE CS2810 Assembler Template

; Student Name:
; Assignment Due Date:


INCLUDE Irvine32.inc
.data
	;--------- Enter Data Here
	vSemester BYTE "CS2810 Summer Semester 2017",0
	vAssignment BYTE "Assembler Assignment #4",0
	vName BYTE "Stephanie Stamm",0
	vPrompt BYTE "Please enter a FAT16 file date: ",0
	vMonthArray BYTE "January",0,"  "
		   BYTE "February",0," "
		   BYTE "March",0,"    "
		   BYTE "April",0,"    "
		   BYTE "May",0,"      "
		   BYTE "June",0,"     "
		   BYTE "July",0,"     "
		   BYTE "August",0,"   "
		   BYTE "September",0
		   BYTE "October",0,"  "
		   BYTE "November",0," "
		   BYTE "December",0," "
	vDay BYTE "--",0
	vSuffixes BYTE "--stndrdthththththththththththththththththstndrdthththththththst",0
	vSuffix BYTE "--",0	
	vMonth BYTE "----------",0
	vYear BYTE "----",0
	vSpace BYTE " ",0
	vComma BYTE ", ",0

.code
main PROC
	;--------- Enter Code Below Here
	call DisplaySemester
	call DisplayAssignment
	call DisplayName
	call PromptUser
	call DisplayMonth
	call DisplayDay
	call DisplaySuffix
	call DisplayYear
	call EndProgram

	call clrscr

	
	DisplayMonth:
		mov dh, 10
		mov dl, 33
		call gotoxy

		mov eax, ecx
		and eax, 0000000111100000b				; isolates middle 4 bits of FAT-16 file date
		shr eax, 5
		sub eax, 1								; compensates for zero-based index

		mov edx, offset vMonthArray
		
		mov bl, 10								; the length of the month including the zero terminator
		mul bl									; multiplies EAX by 10

		add edx, eax

		call WriteString

		mov edx, offset vSpace
		call WriteString

		ret


	DisplayDay:
		mov eax, ecx
		and eax, 0000000000011111b

		cmp eax, 0
		jz EndProgram

		mov bh, 10
		div bh

		add ax, 3030h

		mov word ptr [vDay], ax
		mov edx, offset vDay

		call WriteString

		ret


	DisplaySuffix:
		mov eax, ecx
		and eax, 0000000000011111b
		shl eax, 1									; multiplies eax by 2, which is the length of the suffix, so increases our offset
		mov edx, offset [vSuffixes]					; move the offset of the memory address to edx register
		add edx, eax								; adds the array offset to the memory address offset to find the index we seek
		mov bx, word ptr [edx]						; moves the contents of the address into the bx register. BX has 16 bits available, so by using this register, we limit ourselves two only two characters artificially
		mov word ptr [vSuffix], bx
		
		mov edx, offset [vSuffix]
		call WriteString

		mov edx, offset vComma
		call WriteString

		ret


	DisplayYear:
		mov eax, ecx
		and eax, 1111111000000000b				; isolates first 7 bits of FAT-16 file date

		shr eax, 9
		add eax, 1980							; FAT 16 years need to have 1980 added to them

		xor dx, dx								; fastest way to clear out dx
		mov bx, 1000							; divide by 1000 because we are trying to calculate thousandths place
		div bx									; divides the contents of EAX by 1000
		add al, 30h								; converts to ASCII character code. Uses lower AX register b/c the number is small enough to store there
		mov byte ptr [vYear], al
		
		mov ax, dx
		xor dx, dx
		mov bx, 100								; divide by 100 to get the hundreths place
		div bx
		add al, 30h
		mov byte ptr [vYear+1], al

		mov ax, dx
		mov bl, 10
		div bl									; can use lower BX register b/c 10 is small enough to store there
		
		add ax, 3030h
		
		mov word ptr [vYear+2], ax				; moves contents of AX register into the vYear variable
		mov edx, offset [vYear]

		call WriteString
		
		ret

	
	DisplaySemester:
		mov dh, 4
		mov dl, 33
		call gotoxy

		mov edx, offset vSemester
		call WriteString
		
		ret


	DisplayAssignment:
		mov dh, 5
		mov dl, 33
		call gotoxy

		mov edx, offset vAssignment
		call WriteString
		
		ret


	DisplayName:
		mov dh, 6
		mov dl, 33
		call gotoxy

		mov edx, offset vName
		call WriteString

		ret


	PromptUser:
		mov dh, 8
		mov dl, 33
		call gotoxy

		mov edx, offset vPrompt
		call WriteString

		mov dh, 9
		mov dl, 33
		call gotoxy

		call ReadHex
		ror ax, 8
		mov ecx, eax

		ret

	
	EndProgram:
		xor ecx, ecx
		exit
		ret


main ENDP

END main
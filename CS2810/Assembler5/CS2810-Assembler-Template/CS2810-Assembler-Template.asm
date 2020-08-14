TITLE CS2810 Assembler Template

; Student Name:
; Assignment Due Date:

INCLUDE Irvine32.inc
.data
	;--------- Enter Data Here
	vStartGamePrompt BYTE "Guess a number between 0 and 100: ",0
	vPlayAgainPrompt BYTE "Would you like to play again? (1 for yes, 0 for no) ",13,10,0
	vGuessTooHigh BYTE " is too high",13,10,0
	vGuessTooLow BYTE " is too low",13,10,0
	vGuessCorrect BYTE " is correct!",13,10,0
	vGuessAgain BYTE "Guess again: ",0
	vSemester BYTE "CS2810 Summer Semester 2020",0
	vAssignment BYTE "Assembler #5",0
	vName BYTE "Stephanie Stamm",0

.code
main PROC
	;--------- Enter Code Below Here
	call clrscr

	call DisplaySemester
	call DisplayAssignment
	call DisplayName
	call StartGame
	call EndProgram

	
	StartGame:
		mov edx, offset vStartGamePrompt
		call WriteString

		jmp GenerateRandomNum


	GenerateRandomNum:
		call Randomize
		mov eax, 101
		call RandomRange

		mov ecx, eax

		jmp PlayGame


	PlayGame:
		call ReadDec

		; if user guess is too high
		cmp eax, ecx
		jg GuessIsHigh								; jg -> jump is greater than

		; if user guess is too low
		cmp eax, ecx								; jl -> jump is less than
		jl GuessIsLow

		; if user guess isn't high or low, it must be correct
		jmp GuessIsCorrect


	GuessIsHigh:
		mov edx, eax
		call WriteDec

		mov edx, offset vGuessTooHigh
		call WriteString

		jmp GuessAgain


	GuessIsLow:
		mov edx, eax
		call WriteDec

		mov edx, offset vGuessTooLow
		call WriteString

		jmp GuessAgain


	GuessIsCorrect:
		call WriteDec
		mov edx, offset vGuessCorrect
		call WriteString

		mov edx, offset vPlayAgainPrompt
		call WriteString

		call ReadDec

		cmp eax, 1							; keep playing
		jz StartGame

		jmp EndProgram						; end game


	GuessAgain:
		mov edx, offset vGuessAgain
		call WriteString

		jmp PlayGame


	DisplaySemester:
		mov dh, 4
		mov dl, 0
		call gotoxy

		mov edx, offset vSemester
		call WriteString

		ret

	DisplayAssignment:
		mov dh, 5
		mov dl, 0
		call gotoxy

		mov edx, offset vAssignment
		call WriteString

		ret

	DisplayName:
		mov dh, 6
		mov dl, 0
		call gotoxy

		mov edx, offset vName
		call WriteString

		mov dh, 8
		mov dl, 0
		call gotoxy	

		ret


	EndProgram:
		exit
		xor ecx, ecx
		call ReadChar

		ret

main ENDP

END main
TITLE CS2810 Assembler Template

; Student Name:
; Assignment Due Date:

INCLUDE Irvine32.inc
.data
	;--------- Enter Data Here
	vMpeg25 BYTE "MPEG Audio Version 2.5",0
	vMpeg20 BYTE "MPEG Audio Version 2.0", 0
	vMpeg10 BYTE "MPEG Audio Version 1.0",0
	vMpegRe BYTE "MPEG Reserved",0
	vSemester BYTE "CS2810 Summer Semester 2020",0
	vAssignment BYTE "Assembler Assignment #3",0
	vName BYTE "Stephanie Stamm",0
	vPrompt BYTE "Please enter an MP3 frame header in hex format: ",0
	vReserved BYTE "Reserved",0
	vLayer3 BYTE "Layer III",0
	vLayer2 BYTE "Layer II",0
	vLayer1 BYTE "Layer I",0
	v44100hz BYTE "44100 Hz",0
	v22050hz BYTE "22050 Hz",0
	v11025hz BYTE "11025 Hz",0
	v48000hz BYTE "48000 Hz",0
	v24000hz BYTE "24000 Hz",0
	v12000hz BYTE "12000 Hz",0
	v32000hz BYTE "32000 Hz",0
	v16000hz BYTE "16000 Hz",0
	v8000hz BYTE "8000 Hz",0

	
.code
main PROC
	;--------- Enter Code Below Here


	call DisplaySemester
	call DisplayAssignment
	call DisplayName
	call PromptUser
	call ReadMp3Header
	call DisplayVersion
	call DisplayLayerDesc
	call DisplaySamplingRate
	call EndProgram

	call clrscr


	DisplaySemester:
		mov dh, 10
		mov dl, 12
		call gotoxy

		mov edx, offset vSemester
		call WriteString
		
		ret


	DisplayAssignment:
		mov dh, 11
		mov dl, 12
		call gotoxy
		
		mov edx, offset vAssignment
		call WriteString				; always calls what is in EDX register
		
		ret


	DisplayName:
		mov dh, 12
		mov dl, 12
		call gotoxy

		mov edx, offset vName
		call WriteString
		
		ret


	PromptUser:
		mov dh, 13
		mov dl, 12
		call gotoxy

		mov edx, offset vPrompt
		call WriteString

		ret


	ReadMp3Header:
		mov dh, 14
		mov dl, 12
		call gotoxy
		
		call ReadHex
		mov ecx, eax

		ret



	DisplayVersion:
		mov dh, 15
		mov dl, 12
		call gotoxy

		mov eax, ecx				; Numbers need to start with digit, so by adding the 0 we indicate to Assembly to read hex value as number
				;AAAAAAAAAAABBCCDEEEEFFGHIIJJKLMM
		and eax, 00000000000110000000000000000000b	; isolates the MPEG Audio version ID (Bs)
		shr eax, 19

		cmp eax, 00b
		jz dMpeg25						; if eax register contains 00, jump to the method dMpeg25

		cmp eax, 01b
		jz dMpegRe

		cmp eax, 10b
		jz dMpeg20

		mov edx, offset vMpeg10
		jmp DisplayString

		call WriteString
		
		ret


	dMpeg25:
		mov edx, offset vMpeg25
		jmp DisplayString

	dMpeg20:
		mov edx, offset vMpeg20
		jmp DisplayString

	dMpegRe:
		mov edx, offset vMpegRe
		jmp DisplayString


	DisplayLayerDesc:
		mov dh, 16
		mov dl, 12
		call gotoxy

		mov eax, ecx
				;AAAAAAAAAAABBCCDEEEEFFGHIIJJKLMM
		and eax, 00000000000001100000000000000000b
		shr eax, 17

		cmp eax, 00b
		jz dReserved

		cmp eax, 01b
		jz dLayer3

		cmp eax, 10b
		jz dLayer2

		mov edx, offset vLayer1
		jmp DisplayString

		ret

	dReserved:
		mov edx, offset vReserved
		jmp DisplayString

	dLayer3:
		mov edx, offset vLayer3
		jmp DisplayString

	dLayer2:
		mov edx, offset vLayer2
		jmp DisplayString



	DisplaySamplingRate:
		mov dh, 17
		mov dl, 12
		call gotoxy

		mov eax, ecx
		and eax, 00000000000110000000110000000000b				; isolate B and F bits together
		shr eax, 10			; 11000000011

		;---- MPEG version 2.5 conditionals
		cmp eax, 00000000000b
		jz d11025hz

		cmp eax, 00000000001b
		jz d12000hz

		cmp eax, 00000000010b
		jz d8000hz


		;---- MPEG version 2.0 conditionals
		cmp eax, 10000000000b
		jz d22050hz

		cmp eax, 10000000001b
		jz d24000hz

		cmp eax, 10000000010b
		jz d16000hz


		;---- MPEG version 1.0 conditionals
		cmp eax, 11000000000b
		jz d44100Hz

		cmp eax, 11000000001b
		jz d48000hz

		cmp eax, 11000000010b
		jz d32000hz

		jmp dReserved

		ret

	;---- MPEG version 2.5 helper functions
	d11025hz:
		mov edx, offset v11025hz
		jmp DisplayString

	d12000hz:
		mov edx, offset v12000hz
		jmp DisplayString

	d8000hz:
		mov edx, offset v8000hz
		jmp DisplayString

	;---- MPEG version 2.0 helper functions
	d22050hz:
		mov edx, offset v22050hz
		jmp DisplayString

	d24000hz:
		mov edx, offset v24000hz
		jmp DisplayString

	d16000hz:
		mov edx, offset v16000hz
		jmp DisplayString


	;---- MPEG version 1.0 helper functions
	d44100Hz:
		mov edx, offset v44100Hz
		jmp DisplayString

	d48000hz:
		mov edx, offset v48000hz
		jmp DisplayString

	d32000hz:
		mov edx, offset v32000hz
		jmp DisplayString



	DisplayString:
		call WriteString			; always prints from the EDX register
		ret

	EndProgram:
		xor ecx, ecx
		exit
		ret

	
call ReadChar
main ENDP

END main
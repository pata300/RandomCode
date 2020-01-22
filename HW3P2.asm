INCLUDE Irvine32.inc
.data
source BYTE "HANNAH",0

.code
main proc
	mov esi, 0
	mov ecx, LENGTHOF source - 1
	mov edi, 0
L1:
	movzx ax, source[esi]
	inc esi
	PUSH ax
	LOOP L1

	mov esi, 0
	mov ecx, LENGTHOF source - 1

L2:
	POP ax
	mov str2[esi], al
	inc esi
	LOOP L2

	mov esi,0
	mov ecx, LENGTHOF source - 1
	mov eax, 0

L3:
	mov al, str1[edi]
	mov edx, OFFSET str2
	call WriteString
	CMP str2[esi], al
	JNZ L4
	inc edi
	inc esi
	LOOP L3
	
	mov eax, 2553123
	JMP L5

L4:
	mov eax, 0

L5:
	invoke ExitProcess,0
main endp
end main
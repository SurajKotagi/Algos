x = 0
sum = 0
pulse = 0
while(True):
    if(pulse % 2 == 0):
        sum = sum + int(float(input()))
    else:
        input()
    print(sum)
    pulse = pulse + 1

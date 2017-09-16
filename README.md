# colorsRgb565Rgb888

Está é uma classe (main) básica com um conversor de valores de cores RGB.

A classe main espera pelo tipo de cor RGB se é RGB888 ou RGB565 que utiliza um formato diferente de bits para suas cores
e espera pela cor em formato Hexadecimal (Exemplo: 0xFFFF00) ou Decimal (255 255 0) para converter de um formato para o
outro.

Exemplo RGB888
0xFFFF00
FF = 255
FF = 255
00 = 0

Exemplo RGB565
0xFFE0

FF = 1111 1111
E0 = 1110 0000

R = 1111 1    (5 bits)
G = 111 111   (6 bits)
B = 0 0000    (5 bits)

31 63 0

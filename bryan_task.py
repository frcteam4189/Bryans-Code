# Untitled - By: Smack - Tue Dec 17 2019

import sensor, image, time, pyb

sensor.reset()
sensor.set_pixformat(sensor.RGB565)
sensor.set_framesize(sensor.QVGA)
sensor.skip_frames(time = 2000)
led = pyb.LED(4)
threshold = [(100, 100, -6, 6, -27, 3)]

led.on()
while(True):
    count = 0
    distance = 0
    listMode = []
    listMode.clear()
    img = sensor.snapshot()
    for b in img.find_blobs(threshold , area_threshold = 1000, pixel_threshold = 1000):
        count+=1
        listMode.append(b.pixels())
        if(count == 1):
            blob1 = b
        if(count == 2):
            blob2 = b
            distance = blob1.cx() - blob2.cx()


        img.draw_rectangle(b.rect())
        #modeB = statistics.mode(listMode)
        print(b.cx(), "%" ,b.cy(), "%", count, "%", distance, "%", b.rotation(), "%" "1" )
    #else:
    #modeB = statistics.mode(listMode)
    #print(b.cx(), "%" ,b.cy(), "%", count, "%", distance, "%", b.rotation(), "%" ,modeB )


